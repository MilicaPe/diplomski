import {Component, ComponentRef, ViewChild, ViewContainerRef} from '@angular/core';
import {TemplateParamComponent} from "../../components/template-param/template-param.component";
import {MessageService} from "primeng/api";
import {TemplateRuleDto} from "../../model/template-rule-dto";
import {RuleService} from "../../services/rule-service/rule.service";

@Component({
  selector: 'app-add-template',
  templateUrl: './add-template.component.html',
  styleUrls: ['./add-template.component.scss'],
  providers:[MessageService]
})
export class AddTemplateComponent {

  @ViewChild("templateParams", { read: ViewContainerRef }) vcr!: ViewContainerRef;
  refList: ComponentRef<TemplateParamComponent>[] = []
  counter: number = 0

  constructor(private messageService: MessageService, private ruleService:RuleService) {
  }

  ngAfterViewInit(): void {
    this.addTemplateParams();
  }

  addTemplateParams() {
    let ref = this.vcr.createComponent(TemplateParamComponent)
    this.refList.push(ref)
    this.counter++
  }

  removeTemplateParams() {
    if (this.refList.length == 1)
      return
    const index = this.vcr.indexOf(this.refList[this.refList.length-1].hostView)
    if (index != -1) {
      this.vcr.remove(index);
      this.refList.pop()
    }
    this.counter--
  }

  /*
  *   detection: string;
  min: number;
  max: number;
  intensity: string;
  layer: string;
  final: boolean;
  text: string
  * */

  addTemplate() {

    let d : TemplateRuleDto[] = []
    for (let comp of this.refList){
      let dev = comp.instance.templateRuleParam
      if (dev.text == "" || dev.detection=="" || dev.min==0 || dev.max==0 || dev.layer=="" || dev.intensity=="" || dev.finalResult==null) {
        this.showFillDataMessage()
        return
      }
      d.push(comp.instance.templateRuleParam)
    }

    console.log(d)
    this.ruleService.addTemplateRule(d).subscribe(
      next => {
        this.messageService.add({
          key: 'rule-message',
          severity: 'success',
          summary: 'Uspešno dodata pravila',
          detail: 'Uspešno smo dodali nova pravila'
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
          detail: 'Nismo uspeli da dodamo pravilo.'
        })
      }
    )
  }


  private showFillDataMessage() {
    this.messageService.add({
      key: 'rule-message',
      severity: 'error',
      summary: 'Neuspešno popunjavanje forme',
      detail: 'Pre kreiranja pravila popunite sva polja.'
    })
  }

}
