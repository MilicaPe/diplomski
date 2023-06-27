import { Component, OnInit } from '@angular/core';
import {DetectionReportParam} from "../../model/detection-report-param";
import {ReportService} from "../../services/report-service/report.service";
import {ChartData} from "chart.js";
import {MessageService} from "primeng/api";


@Component({
  selector: 'app-report-detection-time',
  templateUrl: './report-detection-time.component.html',
  styleUrls: ['./report-detection-time.component.scss'],
  providers:[MessageService]
})
export class ReportDetectionTimeComponent implements OnInit{

  detections=['SAD', 'DISGUSTED', 'ANGRY', 'FEARFUL', 'BAD', 'SURPRISED',
              'HAPPY', 'USLOVI_ZA_ANKSIOZNOST', 'ANKSIOZNOST', 'GENERALNI_ANKSIOZNI_POREMECAJ',
              'USLOVI_ZA_PANICNI_NAPAD', 'PANICNI_NAPAD', 'PANICNI_POREMECAJ',
              'USLOVI_ZA_SOCIJAlNU_ANKSIOZNOST', 'SOCIJALNA_ANKSIOZNOST', 'SOCIJALNA_FOBIJA']

  param:DetectionReportParam={detection:"", endDate:null, startDate:null}

  data: any;
  options: any;


  constructor(private reportService:ReportService, private messageService:MessageService ) {}

  ngOnInit() {
    const documentStyle = getComputedStyle(document.documentElement);
  }

  getDetectionReport() {
    if(this.isValidParam()){
      console.log(this.param)
      this.reportService.getDetectionReport(this.param).subscribe((res)=>{
        console.log("report");
        console.log(res)

        this.data = {
          labels: ['January', 'February', 'March', 'April', 'May', 'June', 'July'],
          datasets: [
            {
              label: 'Izveštaj',
              data: res.count,
              fill: false,
           //   borderColor: documentStyle.getPropertyValue('--blue-500'),
              tension: 0.4
            }
          ]
        };
        this.data.labels = res.date
        // this.data.datasets[0].label = res.count
        this.data.datasets[0].data = res.count
      })
    }else{
      this.messageService.add({
        key: 'vimm-report-detection',
        severity: 'warn',
        summary: 'Popunite sva polja.'
      })
    }
  }

  isValidParam(){   // dodaj proveru za buducnost ako ima smisla
    return this.param.detection !== "" && this.param.startDate !== null && this.param.endDate != null;
  }
}
