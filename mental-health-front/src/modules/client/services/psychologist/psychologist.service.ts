import { Injectable } from '@angular/core';
import {environment} from "../../../../environments/environment";
import {HttpClient, HttpParams} from "@angular/common/http";
import {QuestionDto} from "../../model/question-dto";
import {Observable} from "rxjs";
import {PsychologistDto} from "../../model/psychologist-dto";

@Injectable({
  providedIn: 'root'
})
export class PsychologistService {

  private readonly API_PATH = environment.api_path + 'psychologist'

  constructor (private readonly httpClient: HttpClient) {
  }

  searchForPsychologist(s: string): Observable<PsychologistDto[]> {
    let params = new HttpParams()
      .set('search', s)
    return this.httpClient.get<PsychologistDto[]>(`${this.API_PATH}/search`, {params});
  }

  addPsychologist(id: number) : Observable<any> {
    return this.httpClient.get<PsychologistDto[]>(`${this.API_PATH}/add/` + id);
  }

  removePsychologist(id: number) {
    return this.httpClient.get<PsychologistDto[]>(`${this.API_PATH}/remove/` + id);
  }

  getPsychologist() {
    return this.httpClient.get<PsychologistDto[]>(`${this.API_PATH}/get`);

  }
}
