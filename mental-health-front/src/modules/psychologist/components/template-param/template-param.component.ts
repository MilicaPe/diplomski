import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {TemplateRuleDto} from "../../model/template-rule-dto";
import {DetectionTypeDto} from "../../model/detection-type-dto";
import {DetectionTypeService} from "../../services/detection-type-service/detection-type.service";
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {numberValidator, stringAndNumber, stringValidator} from "../../validators";

@Component({
  selector: 'app-template-param',
  templateUrl: './template-param.component.html',
  styleUrls: ['./template-param.component.scss']
})
export class TemplateParamComponent implements OnInit{
  detectionTypes: DetectionTypeDto[] = []
  formGroup: FormGroup;
  textFormControl = new FormControl( '', [Validators.required, stringAndNumber])
  private _formBuilder: FormBuilder;

  @Output() templateParams = new EventEmitter<TemplateRuleDto>()


  constructor(_formBuilder: FormBuilder,
              private detectionTypeService: DetectionTypeService) {
    this._formBuilder = _formBuilder;
    this.formGroup = this._formBuilder.group({
      textFormControl: ['', [Validators.required, stringAndNumber]],
    });
  }

  ngOnInit(): void {
    this.detectionTypeService.getMentalDetectionTypes().subscribe(res=>{
      this.detectionTypes = res;
    })
  }

  public templateRuleParam: TemplateRuleDto = {
    text:"", detection:"", finalResult:true, intensity:"", max:0, min:0, layer:""
  };


  emitRule() {
    this.templateParams.emit(this.templateRuleParam)
  }

  check() {
    console.log("SEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEt")
    console.log(this.textFormControl.value)
    console.log(this.formGroup.controls["textFormControl"].value)

    if (this.formGroup.controls["textFormControl"].valid){
      console.log("UDJEEEEE")
      this.templateRuleParam.text = this.formGroup.controls["textFormControl"].value
      console.log(this.templateRuleParam.text)
    }
  }

}
