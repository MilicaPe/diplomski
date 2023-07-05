import {Component, Inject} from '@angular/core';
import {QuestionAnswerByEmotionDto} from "../../../client/model/question-answer-by-emotion-dto";
import {EmotionService} from "../../../client/services/emotion/emotion.service";
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {QuestionAnswerDto} from "../../../client/model/question-answer-dto";
import {DiagnosticService} from "../../../client/services/diagnostic-service/diagnostic.service";

@Component({
  selector: 'app-diagnostic-survey-overview',
  templateUrl: './diagnostic-survey-overview.component.html',
  styleUrls: ['./diagnostic-survey-overview.component.scss']
})
export class DiagnosticSurveyOverviewComponent {
  answers : QuestionAnswerDto[] = []

  constructor(private answerService: DiagnosticService,
              public dialogRef: MatDialogRef<DiagnosticSurveyOverviewComponent>,
              @Inject(MAT_DIALOG_DATA) public id: number) {
    this.answerService.getAnswers(id).subscribe(
      res => {
        this.answers = res
        console.log("RESULT")
        console.log(res)
      }
    )
  }
}
