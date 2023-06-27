import { Injectable } from '@angular/core';
import {environment} from "../../../../environments/environment";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {HistoryDto} from "../../../client/model/history-dto";
import {JobReportParam} from "../../model/job-report-param";
import {DetectionReportParam} from "../../model/detection-report-param";
import {DetectionReportDto} from "../../model/detection-report-dto";

@Injectable({
  providedIn: 'root'
})
export class ReportService {
  private path = environment.api_path+'report';

  constructor(private httpclient:HttpClient) { }

  getReportForUser(userId: number, number: number, rowCount: number):Observable<HistoryDto>{
    return this.httpclient.get<HistoryDto>(`${this.path}/user/${userId}/${number}/${rowCount}`)
  }

  getJobReport(reportParam: JobReportParam):Observable<any>{
    return this.httpclient.post(`${this.path}/job/age/gender`, reportParam);
  }

  getDetectionReport(reportParam: DetectionReportParam):Observable<DetectionReportDto>{
    return this.httpclient.post<DetectionReportDto>(`${this.path}/detection`, reportParam);
  }

}
