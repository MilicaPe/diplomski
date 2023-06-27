import {Component, EventEmitter, Input, Output} from '@angular/core';
import {ResultDto} from "../../model/ResultDto";
import {DiagnosticDto} from "../../model/DiagnosticDto";

@Component({
  selector: 'app-diagnostic-result',
  templateUrl: './diagnostic-result.component.html',
  styleUrls: ['./diagnostic-result.component.scss']
})
export class DiagnosticResultComponent {
  @Input() resultDto: ResultDto={diagnostics:[]};
  // @Input() resultHidden : boolean = true;

  @Output() result = new EventEmitter<ResultDto>();


  constructor() {
  }

  getDiagnostic(diagnostic:DiagnosticDto):string{
    if(diagnostic.detectionType==="ANKSIOZNOST" && diagnostic.questionLayer==="FIRST")
      return "Uslovi za anksioznost"
    else if(diagnostic.detectionType==="ANKSIOZNOST" && diagnostic.questionLayer==="SECOND")
      return "Anksioznost"
    else if(diagnostic.detectionType==="ANKSIOZNOST" && diagnostic.questionLayer==="THIRD")
      return "Generalni anksiozni poremećaj"
    else if(diagnostic.detectionType==="PANICNI_NAPAD" && diagnostic.questionLayer==="FIRST")
      return "Uslovi za panični napad"
    else if(diagnostic.detectionType==="PANICNI_NAPAD" && diagnostic.questionLayer==="SECOND")
      return "Panični napad"
    else if(diagnostic.detectionType==="PANICNI_NAPAD" && diagnostic.questionLayer==="THIRD")
      return "Panični poremećaj"
    else if(diagnostic.detectionType==="SOCIJALNA_ANKSIOZNOST" && diagnostic.questionLayer==="FIRST")
      return "Uslovi za socijalnu anksioznost"
    else if(diagnostic.detectionType==="SOCIJALNA_ANKSIOZNOST" && diagnostic.questionLayer==="SECOND")
      return "Socijalna anksioznost"
    else
      return "Socijalna fobija"
  }

  isFinal() {
    let final = this.resultDto.diagnostics.filter(diagnostic => diagnostic.finalResult===false).length
    return final === 0;
  }

  continueQuestionnaire() {
    this.result.emit(this.resultDto);
  }
}
