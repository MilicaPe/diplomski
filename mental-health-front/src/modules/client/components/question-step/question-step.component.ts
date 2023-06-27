import {Component, Input} from '@angular/core';
import {QuestionDto} from "../../model/question-dto";
import {MatRadioChange} from "@angular/material/radio";
import {AnswerDto} from "../../model/answer-dto";

@Component({
  selector: 'app-question-step',
  templateUrl: './question-step.component.html',
  styleUrls: ['./question-step.component.scss']
})
export class QuestionStepComponent {

  @Input() questions: QuestionDto[] | undefined;
  @Input() answers : AnswerDto[] = [];

  constructor() {
    if (this.questions == undefined) return

  }


  optionChanged($event: MatRadioChange, questionId: number) {
    for (let a of this.answers){
      if (a.questionId == questionId){
        a.score = $event.value
      }
    }
  }
}
