import {Component, Inject} from '@angular/core';
import {EmotionService} from "../../../client/services/emotion/emotion.service";
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {EmotionResult} from "../../../client/model/emotion-result";
import {QuestionAnswerDto} from "../../../client/model/question-answer-dto";
import {QuestionAnswerByEmotionDto} from "../../../client/model/question-answer-by-emotion-dto";
import {EmotionHistoryDto} from "../../../client/model/emotion-history-dto";

@Component({
  selector: 'app-emotion-survey-overview',
  templateUrl: './emotion-survey-overview.component.html',
  styleUrls: ['./emotion-survey-overview.component.scss']
})
export class EmotionSurveyOverviewComponent {

  answers : QuestionAnswerByEmotionDto[] = []

  constructor(private emotionService: EmotionService,
              public dialogRef: MatDialogRef<EmotionSurveyOverviewComponent>,
              @Inject(MAT_DIALOG_DATA) public emotionHistoryDto: EmotionHistoryDto) {
    this.emotionService.getDetailedEmotionSurvey(emotionHistoryDto.id).subscribe(
      res => {
        this.answers = res
        console.log("RESULT")
        console.log(res)
      }
    )
  }
}
