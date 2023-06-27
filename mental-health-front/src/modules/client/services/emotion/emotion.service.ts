import { Injectable } from '@angular/core';
import {environment} from "../../../../environments/environment";
import {HttpClient} from "@angular/common/http";
import {RegistrationRequest} from "../../../auth/model/registration-request";
import {Observable} from "rxjs";
import {QuestionDto} from "../../model/question-dto";
import {SurveyDto} from "../../model/survey-dto";
import {EmotionHistoryDto} from "../../model/emotion-history-dto";
import {HistoryDto} from "../../model/history-dto";
import {QuestionAnswerDto} from "../../model/question-answer-dto";
import {QuestionAnswerByEmotionDto} from "../../model/question-answer-by-emotion-dto";

@Injectable({
  providedIn: 'root'
})
export class EmotionService {

  private readonly API_PATH = environment.api_path + 'emotions'

  constructor (private readonly httpClient: HttpClient) {
  }

  getQuestions() : Observable<QuestionDto[]>{
    return this.httpClient.get<QuestionDto[]>(`${this.API_PATH}/questions`)
  }

  takeSurvey(param: SurveyDto): Observable<any> {
    return this.httpClient.post(`${this.API_PATH}/survey`, param)

  }

  getEmotionHistory(number: number, rowCount: number) : Observable<HistoryDto>{
    return this.httpClient.get<HistoryDto>(`${this.API_PATH}/results/${number}/${rowCount}`)
  }

getDetailedEmotionSurvey(id: number) : Observable<QuestionAnswerByEmotionDto[]> {
    return this.httpClient.get<QuestionAnswerByEmotionDto[]>(`${this.API_PATH}/answers/${id}`)
  }
}
