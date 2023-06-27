import { Component, OnInit } from '@angular/core';
import { ReportService } from '../../services/report-service/report.service';
import {UserService} from "../../services/user-service/user.service";
import {JobReportParam} from "../../model/job-report-param";
import {JobReportDto} from "../../model/job-report-dto";
import {MessageService} from "primeng/api";

interface Gender {
  value: string;
  viewValue: string;
}

@Component({
  selector: 'app-report-based-on-job-age',
  templateUrl: './report-based-on-job-age.component.html',
  styleUrls: ['./report-based-on-job-age.component.scss'],
  providers: [MessageService]
})
export class ReportBasedOnJobAgeComponent implements OnInit{
  jobs: string[]=[];

  genders: Gender[] = [
    {value: 'FEMALE', viewValue: 'Ženski'},
    {value: 'MALE', viewValue: 'Muški'},
    {value: 'ALL', viewValue: 'Oba'},
  ];

  reportParam:JobReportParam={job:"", endYear:1900, startYear:1900, gender:""}

  report: JobReportDto[] =[]

  constructor(private reportService:ReportService,
              private userService: UserService,
              private messageService: MessageService) {}

  ngOnInit(): void {
    this.userService.getJobs().subscribe((res)=>{
      this.jobs = res;
      console.log("yanimanjaaa")
      console.log(res)
    })
  }

  getReport() {
    if (this.isValidParams()) {
      this.reportService.getJobReport(this.reportParam).subscribe((res) => {
        console.log(res);
        this.report = res;
      })

    }
    else{
      this.messageService.add({
        key: 'vimm-report-job',
        severity: 'warn',
        summary: 'Popunite sva polja.'
      })
    }
  }

  isValidParams():boolean{
    return this.reportParam.gender !== "" && this.reportParam.job != "";
  }
}
