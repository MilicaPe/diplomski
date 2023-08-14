import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class TitleService {

  constructor() { }

  getTitle(url: string): string {
    switch (url){
      case '/client/questionnaire': return 'Dijagnostika'
      case '/client/emotion': return 'Emocije'
      case '/client/psychologist': return 'Dodaj psihologa'
      case '/client/list': return 'Lista psihologa'
      case '/psychologist/home': return 'Izveštaji'
      case '/psychologist/template': return 'Dodavanje novog templejta'
      case '/psychologist/new/survey': return 'Definisanje novih pitanja'
    }
    return '';
  }
}
