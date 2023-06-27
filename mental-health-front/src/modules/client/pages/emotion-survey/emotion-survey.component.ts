import { Component } from '@angular/core';
import {MessageService} from "primeng/api";
import {QuestionDto} from "../../model/question-dto";
import {EmotionService} from "../../services/emotion/emotion.service";
import {AnswerDto} from "../../model/answer-dto";
import {MatDialog} from "@angular/material/dialog";
import {EmotionResultComponent} from "../../components/emotion-result/emotion-result.component";
import {EmotionResult} from "../../model/emotion-result";

@Component({
  selector: 'app-emotion-survey',
  templateUrl: './emotion-survey.component.html',
  styleUrls: ['./emotion-survey.component.scss'],
  providers: [MessageService]
})
export class EmotionSurveyComponent {
  isCompleted: boolean = true;
  isLinear: boolean = false;
  firstSetOfQuestions: QuestionDto[] = [{id: 1, text: "First"}];
  // fullQuestionList : QuestionDto[] = [];
  q: QuestionDto[][] = [];
  answers: AnswerDto[][] = []

  constructor(
    public dialog: MatDialog,
    private emotionService: EmotionService) {
    // let e : EmotionResult = {detectionType: "HAPPY", time: [2023,5,26,15,50]}
    // this.openResultDialog(e);
    this.emotionService.getQuestions().subscribe(
      (res) => {
        // this.fullQuestionList = res
        let count = Math.round(res.length / 6)
        for (let i = 0; i < 6; i++){
          // console.log(count * i)
          // console.log(count * (i+1))
          // console.log(this.fullQuestionList.splice(0, count * (i+1)))
          let next = res.splice(0, count)
          this.q.push(next)

          let aX: AnswerDto[] = []
          for (let q of this.q[i]){
            if (q.id == 186) console.log("186 FOUND set to 1")
            aX.push( {questionId: q.id, score: 1})
          }
          this.answers.push(aX);
        }
        console.log("QUESTIONS")
        console.log(this.q)
      }
    )
  }

  submitRequest() {
    let result = []
    for (let a of this.answers){
      result.push(...a)
    }

    console.log("SUBMIIIIIIIIIIIIIT")
    console.log(result)

    this.emotionService.takeSurvey({answers: result}).subscribe(
      res => {
        console.log("RESULT")
        console.log(res)
        if (res.detectionType == null)
          res.detectionType = "Nismo mogli da nađemo rezultat.\n Molimo Vas proverite svoje odgovore."
        this.openResultDialog(res);
      },
      err => {
        console.log(err)
      }
    )

  }

  openResultDialog(result: any): void {
    let dialogRef
    dialogRef = this.dialog.open(EmotionResultComponent, {
      width: '30%',
      height: '60%',
      data: result
    })

    dialogRef.afterClosed().subscribe((res) => {
      console.log('The dialog was closed')
      // if (res) {
      //   for (let r of this.patents) {
      //     if (r.id[0] === idElement) {
      //       r.hasSolution[0] = 'true'
      //     }
      //   }
      // }
    })
  }
}
