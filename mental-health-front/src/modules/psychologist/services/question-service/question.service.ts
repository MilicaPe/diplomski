import { Injectable } from '@angular/core';
import {environment} from "../../../../environments/environment";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {DetectionTypeDto} from "../../model/detection-type-dto";
import {QuestionParamDto} from "../../model/question-param-dto";

@Injectable({
  providedIn: 'root'
})
export class QuestionService {


  private path = environment.api_path;

  constructor(private httpclient:HttpClient) { }

  addNewQuestions(questions:QuestionParamDto[]):Observable<any>{
    return this.httpclient.post<any>(`${this.path}question/add`, questions)
  }
}
