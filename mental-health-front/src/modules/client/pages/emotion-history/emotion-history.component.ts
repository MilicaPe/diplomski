import {Component} from '@angular/core';
import {EmotionService} from "../../services/emotion/emotion.service";
import {EmotionHistoryDto} from "../../model/emotion-history-dto";
import {LazyLoadEvent} from "primeng/api";
import {MatDialog} from "@angular/material/dialog";
import {
  EmotionSurveyOverviewComponent
} from "../../../shared/components/emotion-survey-overview/emotion-survey-overview.component";
import {
  DiagnosticSurveyOverviewComponent
} from "../../../shared/components/diagnostic-survey-overview/diagnostic-survey-overview.component";

@Component({
  selector: 'app-emotion-history',
  templateUrl: './emotion-history.component.html',
  styleUrls: ['./emotion-history.component.scss']
})
export class EmotionHistoryComponent {

  historyList: EmotionHistoryDto[] = []
  totalRecords: any;
  rowCount: number = 1;
  loading: boolean = false;

  constructor(private emotionService: EmotionService,
              public dialog: MatDialog) {
    this.getEmotionHistory(0, this.rowCount)
  }

  nextPage(event: LazyLoadEvent) {
    setTimeout(() => {
      this.loading = true
      if (event.first === undefined) {
        event.first = 0
      }
      if (event.rows === undefined) {
        event.rows = 5
      }
      this.rowCount = event.rows;
      this.getEmotionHistory(event.first / event.rows, event.rows)
    }, 500)
  }

  private getEmotionHistory(number: number, rowCount: number) {
    this.emotionService.getEmotionHistory(number, rowCount).subscribe(data => {
      console.log("EMOTION HISTORY")
      console.log(data);
      this.totalRecords = data.totalCount
      this.historyList = data.resultList
      this.loading = false
    })
  }

  openDialog(dto: EmotionHistoryDto) {
    if (dto.emotion) {
      const dialogRef = this.dialog.open(EmotionSurveyOverviewComponent, {
        width: '70%',
        height: '95%',
        data: dto
      })
      dialogRef.afterClosed().subscribe(() => {
        console.log('The dialog was closed')
      })
    }else {
      const dialogRef = this.dialog.open(DiagnosticSurveyOverviewComponent, {
        width: '70%',
        height: '95%',
        data: dto
      })
      dialogRef.afterClosed().subscribe(() => {
        console.log('The dialog was closed')
      })
    }
  }
}
