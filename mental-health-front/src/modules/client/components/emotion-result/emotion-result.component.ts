import {Component, Inject} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {EmotionResult} from "../../model/emotion-result";

@Component({
  selector: 'app-emotion-result',
  templateUrl: './emotion-result.component.html',
  styleUrls: ['./emotion-result.component.scss']
})
export class EmotionResultComponent {

  constructor(public dialogRef: MatDialogRef<EmotionResultComponent>,
              @Inject(MAT_DIALOG_DATA) public result: EmotionResult) {
  }
}
