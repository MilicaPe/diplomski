import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {AnswerDto} from "../../model/AnswerDto";
import {Observable} from "rxjs";
import {environment} from "../../../../environments/environment";
import {ResultDto} from "../../model/ResultDto";
import {QuestionAnswerDto} from "../../model/question-answer-dto";
import {DepressionMarkDto} from "../../model/depression-mark-dto";

@Injectable({
  providedIn: 'root'
})
export class DiagnosticService {

  private path = environment.api_path+'diagnostic';


  constructor(private httpClient: HttpClient) { }

  postAnswers(answers: AnswerDto[]):Observable<ResultDto>{
    return this.httpClient.post<ResultDto>(`${this.path}/survey`, answers);
  }

  getAnswers(id: number) : Observable<QuestionAnswerDto[]>{
    return this.httpClient.get<QuestionAnswerDto[]>(`${this.path}/get/${id}`);
  }

  getSymptom(selected: string):Observable<string[]> {
    return this.httpClient.get<string[]>(`${this.path}/get/sym/${selected}`);
  }
  getDepressionMark():Observable<DepressionMarkDto[]>{
    return this.httpClient.get<DepressionMarkDto[]>(`${this.path}/depression/mark`);
  }
}
