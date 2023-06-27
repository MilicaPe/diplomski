import {NgModule} from "@angular/core";
import {CommonModule} from "@angular/common";
import {DateArrayToStringPipe} from "./pipes/date-array-to-string.pipe";
import { EmotionTypeToStringPipe } from './pipes/emotion-type-to-string.pipe';
import { DetectionTypeToStringPipe } from './pipes/detection-type-to-string.pipe';
import { SymptomToStringPipe } from './pipes/symptom-to-string.pipe';


@NgModule({
  declarations: [
    DateArrayToStringPipe,
    EmotionTypeToStringPipe,
    DetectionTypeToStringPipe,
    SymptomToStringPipe
  ],
  imports: [
    CommonModule
  ],
    exports: [
        DateArrayToStringPipe,
        EmotionTypeToStringPipe,
        DetectionTypeToStringPipe,
        SymptomToStringPipe
    ],
  providers: []

})
export class SharedModule{}
