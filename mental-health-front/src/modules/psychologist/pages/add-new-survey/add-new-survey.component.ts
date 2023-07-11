import {Component, ComponentRef, ViewChild, ViewContainerRef} from '@angular/core';
import {AddNewQuestionComponent} from "../../components/add-new-question/add-new-question.component";
import {MessageService} from "primeng/api";
import {QuestionParamDto} from "../../model/question-param-dto";
import {QuestionService} from "../../services/question-service/question.service";

@Component({
  selector: 'app-add-new-survey',
  templateUrl: './add-new-survey.component.html',
  styleUrls: ['./add-new-survey.component.scss'],
  providers: [MessageService]
})
export class AddNewSurveyComponent {


  @ViewChild("questionParams", { read: ViewContainerRef }) vcr!: ViewContainerRef;
  refList: ComponentRef<AddNewQuestionComponent>[] = []
  counter: number = 0

  constructor(private messageService:MessageService, private questionService:QuestionService) {


  }

  ngAfterViewInit(): void {
    this.addQuestionParams();
  }

  addQuestionParams() {
    let ref = this.vcr.createComponent(AddNewQuestionComponent)
    this.refList.push(ref)
    this.counter++
  }

  removeQuestionParams() {
    if (this.refList.length == 1)
      return
    const index = this.vcr.indexOf(this.refList[this.refList.length-1].hostView)
    if (index != -1) {
      this.vcr.remove(index);
      this.refList.pop()
    }
    this.counter--
  }


  addQuestion() {
    let d : QuestionParamDto[] = []
    for (let comp of this.refList){
      let dev = comp.instance.param
      if (dev.text == "" || dev.detection=="" || dev.depressionMark==null || dev.positive==null || dev.layer=="") {
        this.showFillDataMessage()
        return
      }
      d.push(comp.instance.param)
    }

    console.log(d)
    this.questionService.addNewQuestions(d).subscribe(
      next => {
        this.messageService.add({
          key: 'rule-message',
          severity: 'success',
          summary: 'Uspešno dodata pitanja',
          detail: 'Uspešno smo dodali nova pitanja'
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
          detail: 'Nismo uspeli da dodamo pitanja.'
        })
      }
    )
  }


  private showFillDataMessage() {
    this.messageService.add({
      key: 'rule-message',
      severity: 'error',
      summary: 'Neuspešno popunjavanje forme',
      detail: 'Pre kreiranja pitanja popunite sva polja.'
    })
  }

}
