import {Component, EventEmitter, Input, Output} from '@angular/core';
import {ResultDto} from "../../model/ResultDto";
import {DiagnosticDto} from "../../model/DiagnosticDto";
import {DiagnosticService} from "../../services/diagnostic-service/diagnostic.service";
import {DepressionMarkDto} from "../../model/depression-mark-dto";

@Component({
  selector: 'app-diagnostic-result',
  templateUrl: './diagnostic-result.component.html',
  styleUrls: ['./diagnostic-result.component.scss']
})
export class DiagnosticResultComponent {
  @Input() resultDto: ResultDto={diagnostics:[]};
  // @Input() resultHidden : boolean = true;

  @Output() result = new EventEmitter<ResultDto>();

  depressionMarkRes:DepressionMarkDto[] = []
  isMark:boolean = true;

  constructor(private diagnosticService:DiagnosticService) {
  }


  isFinal() {
    let final = this.resultDto.diagnostics.filter(diagnostic => diagnostic.finalResult===false).length
    return final === 0;
  }

  continueQuestionnaire() {
    this.result.emit(this.resultDto);
  }

  getDepressionMark() {
    this.diagnosticService.getDepressionMark().subscribe(res=>{
      this.depressionMarkRes = res;
      this.isMark = false;
    })

  }

  isMarkExist(){
    if(this.depressionMarkRes.length!==0) {return false;}else {return true;}
  }

}
