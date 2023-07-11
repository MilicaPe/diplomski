import { Injectable } from '@angular/core';
import {environment} from "../../../../environments/environment";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {DetectionTypeDto} from "../../model/detection-type-dto";

@Injectable({
  providedIn: 'root'
})
export class DetectionTypeService {

  private path = environment.api_path;

  constructor(private httpclient:HttpClient) { }

  getMentalDetectionTypes():Observable<DetectionTypeDto[]>{
    return this.httpclient.get<DetectionTypeDto[]>(`${this.path}detection/mental`)
  }
}
