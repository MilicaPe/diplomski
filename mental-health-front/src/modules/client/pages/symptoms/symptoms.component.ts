import { Component } from '@angular/core';
import {AnswerService} from "../../services/answer-service/answer.service";

interface Symptom {
  value: string;
  viewValue: string;
}

@Component({
  selector: 'app-symptoms',
  templateUrl: './symptoms.component.html',
  styleUrls: ['./symptoms.component.scss']
})
export class SymptomsComponent {


  symptoms: Symptom[] = [
   // {value: 'USLOV_ANK', viewValue: 'Uslovi za anksioznost'},
    {value: 'ANK', viewValue: 'Anksioznost'},
    {value: 'GAD', viewValue: 'Genereralni anksiozni poremećaj'},
    //{value: 'USLOV_PAN', viewValue: 'Uslovi za panični napad'},
    {value: 'PAN', viewValue: 'Panični napad'},
    {value: 'PAN_POR', viewValue: 'Panični poremećaj'},
   // {value: 'USLOV_SOC', viewValue: 'Uslovi za socijalnu anksioznost'},
    {value: 'SOC', viewValue: 'Socijalna anksioznost'},
    {value: 'SOC_FOB', viewValue: 'Socijalna fobija'},
  ];
  selected: string="";
  result:string[]=[];
  showSelected: string="";

  constructor(private answerService: AnswerService) {}


  getSymptoms() {
    if(this.selected!==""){
      this.showSelected=this.selected
      this.answerService.getSymptom(this.selected).subscribe((res)=>{
        this.result = res;
      })
    }else{
      // toast
    }
  }
}
/*
*
*   USLOV_ANK(0),
    ANK(1),
    GAD(2),
    USLOV_PAN(3),
    PAN(4),
    PAN_POR(5),
    USLOV_SOC(6),
    SOC(7),
    SOC_FOB(8);
* */
