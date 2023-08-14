import {Component, OnInit} from '@angular/core';
import {UserDto} from "../../model/user-dto";
import {UserService} from "../../services/user-service/user.service";
import {ReportService} from "../../services/report-service/report.service";
import {ReportDto} from "../../model/report-dto";
import {LazyLoadEvent, MessageService} from "primeng/api";
import {EmotionHistoryDto} from "../../../client/model/emotion-history-dto";
import {
  EmotionSurveyOverviewComponent
} from "../../../shared/components/emotion-survey-overview/emotion-survey-overview.component";
import {
  DiagnosticSurveyOverviewComponent
} from "../../../shared/components/diagnostic-survey-overview/diagnostic-survey-overview.component";
import {MatDialog} from "@angular/material/dialog";

@Component({
  selector: 'app-user-report',
  templateUrl: './user-report.component.html',
  styleUrls: ['./user-report.component.scss'],
  providers: [MessageService]
})
export class UserReportComponent implements OnInit {
  clients: UserDto[] = []
  selectedUserId: number = -10;

  historyList: ReportDto[] = []
  totalRecords: any;
  rowCount: number = 5;
  loading: boolean = false;

  constructor(private userService: UserService,
              public dialog: MatDialog,
              private repostService: ReportService,
              private messageService:MessageService) {
  }

  ngOnInit(): void {
    this.userService.getClients().subscribe((res) => {
      console.log("users")
      console.log(res)
      this.clients = res;
    })

  }

  getReportForUser(number: number, rowCount: number) {
    if (this.selectedUserId === -10) {
      console.log("odaberi korisnikeeee");  // toast
      this.messageService.add({
        key: 'vimm-report-user',
        severity: 'warn',
        summary: 'Izaberite korisnika za koga želite izveštaj.'
      })

    } else {
      this.repostService.getReportForUser( this.selectedUserId, number, rowCount,).subscribe((res) => {
        console.log("stigao je izvestaj za korisnika " + this.selectedUserId)
        this.historyList = res.resultList;
        this.totalRecords = res.totalCount
        this.loading = false
        console.log(res)
      })
    }
  }

  nextPage(event: LazyLoadEvent) {
    setTimeout(() => {
      this.loading = true
      if (event.first === undefined) { event.first = 0 }
      if (event.rows === undefined) { event.rows = 5 }
      this.rowCount = event.rows;
      this.getReportForUser( event.first / event.rows, event.rows)
    }, 500)
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
