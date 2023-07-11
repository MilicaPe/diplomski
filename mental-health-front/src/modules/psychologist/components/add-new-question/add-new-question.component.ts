import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {DetectionTypeService} from "../../services/detection-type-service/detection-type.service";
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {QuestionParamDto} from "../../model/question-param-dto";
import {DetectionTypeDto} from "../../model/detection-type-dto";
import {MatRadioChange} from "@angular/material/radio";

@Component({
  selector: 'app-add-new-question',
  templateUrl: './add-new-question.component.html',
  styleUrls: ['./add-new-question.component.scss']
})
export class AddNewQuestionComponent implements OnInit{
  formGroup: FormGroup;
  textFormControl = new FormControl( '', [Validators.required])
  private _formBuilder: FormBuilder;
  detectionTypes:DetectionTypeDto[] = []
  other:DetectionTypeDto={type:"Drugo"}

  constructor(_formBuilder: FormBuilder,
              private detectionTypeService: DetectionTypeService) {
    this._formBuilder = _formBuilder;
    this.formGroup = this._formBuilder.group({
      textFormControl: ['', [Validators.required]],
    });
  }

  ngOnInit(): void {
    this.detectionTypeService.getMentalDetectionTypes().subscribe(res=>{
      this.detectionTypes = res;
      this.detectionTypes.push(this.other)
    })
  }


  @Output() questionParams = new EventEmitter<QuestionParamDto>()

  public param: QuestionParamDto = {
    text:"", positive:true, depressionMark:false, detection:"", layer:""
  };

//  questionsParam: QuestionParamDto[] = []
  isOther: boolean = true;


  emitRule() {
    this.questionParams.emit(this.param)
  }


  check() {
    console.log("pre provere forme")
    console.log(this.textFormControl.value)
    console.log(this.formGroup.controls["textFormControl"].valid)
     if (/* this.formGroup.controls["textFormControl"].valid  && */    this.textFormControl.value !== null){
      console.log("UDJEEEEE")
      this.param.text = this.textFormControl.value
      console.log(this.param.text)
    }
    /*
    * else
    * */
  }

  analyseCheckedType($event: any) {
    console.log($event)
    if($event ==="Drugo"){
      this.isOther = false
    }else{
      this.isOther = true
      this.param.detection = $event
    }
  }

  setPositive($event: MatRadioChange) {
    this.param.positive = $event.value
  }

  setDepressionMark($event: MatRadioChange) {
    this.param.depressionMark = $event.value
  }
}
