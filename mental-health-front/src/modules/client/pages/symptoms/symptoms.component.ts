import { Component } from '@angular/core';
import {DiagnosticService} from "../../services/diagnostic-service/diagnostic.service";

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
    {value: 'ANKSIOZNOST', viewValue: 'Anksioznost'},
    {value: 'GENERALNI_ANKSIOZNI_POREMECAJ', viewValue: 'Genereralni anksiozni poremećaj'},
    {value: 'PANICNI_NAPAD', viewValue: 'Panični napad'},
    {value: 'PANICNI_POREMECAJ', viewValue: 'Panični poremećaj'},
    {value: 'SOCIJALNA_ANKSIOZNOST', viewValue: 'Socijalna anksioznost'},
    {value: 'SOCIJALNA_FOBIJA', viewValue: 'Socijalna fobija'},
  ];
  selected: string="";
  result:string[]=[];
  showSelected: string="";

  constructor(private answerService: DiagnosticService) {}


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
