import { Component } from '@angular/core';
import {PsychologistDto} from "../../model/psychologist-dto";
import {PsychologistService} from "../../services/psychologist/psychologist.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-view-psychologist',
  templateUrl: './view-psychologist.component.html',
  styleUrls: ['./view-psychologist.component.scss']
})
export class ViewPsychologistComponent {
  psychologists: PsychologistDto[] = [];

  constructor(private psychologistService: PsychologistService,
              private router: Router) {
    this.psychologistService.getPsychologist().subscribe(
      (res) => {
        this.psychologists = res;
        console.log("RESULT")
        console.log(res)
      }, err => {
        console.log("ERROR")
        console.log(err)

      }
    )
  }

  removePsychologist(id: number) {
    this.psychologistService.removePsychologist(id).subscribe(
      (res) => {
        this.psychologists = res;
        console.log("RESULT")
        console.log(res)
      }, err => {
        console.log("ERROR")
        console.log(err)

      }
    )
  }
}
