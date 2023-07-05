import {Component, ComponentRef, OnInit, ViewChild, ViewContainerRef} from '@angular/core';
import {FormControl, Validators} from "@angular/forms";
import {QuestionDto} from "../../../client/model/QuestionDto";
import {QuestionService} from "../../../client/services/question-service/question.service";
import {RuleParamsComponent} from "../../components/rule-params/rule-params.component";
import {MessageService} from "primeng/api";
import {RuleParamsDto} from "../../model/rule-params-dto";
import {RuleDto} from "../../model/rule-dto";
import {RuleService} from "../../services/rule-service/rule.service";

@Component({
  selector: 'app-define-rules',
  templateUrl: './define-rules.component.html',
  styleUrls: ['./define-rules.component.scss'],
  providers: [MessageService]
})
export class DefineRulesComponent{

  messageFormControl = new FormControl('Podrazumevana poruka pravila tipa 1', [Validators.required, Validators.pattern('[ A-ZČĆŠĐŽa-zčćšđž0-9<>=]{2,80}')]);

  @ViewChild("ruleParams", { read: ViewContainerRef }) vcr!: ViewContainerRef;
  refList: ComponentRef<RuleParamsComponent>[] = []
  counter: number = 0

  constructor(private messageService:MessageService, private ruleService:RuleService) {
  }

  ngAfterViewInit(): void {
    this.addRuleParams();
  }

  addRuleParams() {
    let ref = this.vcr.createComponent(RuleParamsComponent)
    this.refList.push(ref)
    this.counter++
  }

  removeRuleParams() {
    if (this.refList.length == 1)
      return
    const index = this.vcr.indexOf(this.refList[this.refList.length-1].hostView)
    if (index != -1) {
      this.vcr.remove(index);
      this.refList.pop()
    }
    this.counter--
  }

  addRule() {
    let d : RuleParamsDto[] = []
    for (let comp of this.refList){
      let dev = comp.instance.rule
      if (dev.value == null) {
        this.showFillDataMessage()
        return
      }
      d.push(comp.instance.rule)
    }
    if (!this.messageFormControl.valid || this.messageFormControl.value == null) {
      this.showFillDataMessage()
      return;
    }
    let param: RuleDto = {
      ruleParams: d,
      message: this.messageFormControl.value
    }
    console.log(param)
    this.ruleService.addRule(param).subscribe(
      next => {
        this.messageService.add({
          key: 'rule-message',
          severity: 'success',
          summary: 'Uspešno dodato',
          detail: 'Uspešno smo dodali novo pravilo'
        })
        console.log("ADDED RULE")
        console.log(next)
      },
      err => {
        console.log("ERROR")
        console.log(err)
        this.messageService.add({
          key: 'rule-message',
          severity: 'error',
          summary: 'Neuspešno dodato',
          detail: 'Nismo uspeli da dodamo pravilo'
        })
      }
    )
  }

  private showFillDataMessage() {
    this.messageService.add({
      key: 'rule-message',
      severity: 'error',
      summary: 'Neuspešno popunjavanje forme',
      detail: 'Pre kreiranja pravila popunite sve polje'
    })
  }
}
