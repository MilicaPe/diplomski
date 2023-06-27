import { Component } from '@angular/core';
import {PsychologistService} from "../../services/psychologist/psychologist.service";
import {PsychologistDto} from "../../model/psychologist-dto";
import {Router} from "@angular/router";

@Component({
  selector: 'app-add-psychologist',
  templateUrl: './add-psychologist.component.html',
  styleUrls: ['./add-psychologist.component.scss']
})
export class AddPsychologistComponent {
  psychologists: PsychologistDto[] = [];
  searchParam : string = ""

  constructor(private psychologistService: PsychologistService,
              private router: Router) {
  }

  findPsychologist() {
    console.log("BY")
    console.log(this.searchParam);
    this.psychologistService.searchForPsychologist(this.searchParam).subscribe(
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

  addPsychologist(id: number) {
    this.psychologistService.addPsychologist(id).subscribe(
      (res) => {
        this.router.navigateByUrl("/client/list");
        console.log("RESULT")
        console.log(res)
      }, err => {
        console.log("ERROR")
        console.log(err)

      }
    )
  }
}
