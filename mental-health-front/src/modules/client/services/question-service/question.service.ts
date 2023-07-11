import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from "../../../../environments/environment";
import {Observable} from "rxjs";
import {PaginationDto} from "../../model/PaginationDto";
import {QuestionDto} from "../../model/QuestionDto";

@Injectable({
  providedIn: 'root'
})
export class QuestionService {
  private path = environment.api_path+'question';

  constructor(private httpClient:HttpClient) { }

  getQuestionSet(layer:string, type:string[]) : Observable<PaginationDto> {
    return this.httpClient.post<PaginationDto>(`${this.path}/${layer}`, type);
  }

  getDepressionQuestionSet() : Observable<QuestionDto[]> {
    return this.httpClient.get<QuestionDto[]>(`${this.path}/depression`);
  }

}
