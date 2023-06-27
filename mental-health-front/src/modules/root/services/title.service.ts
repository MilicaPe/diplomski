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
    }
    return '';
  }
}
