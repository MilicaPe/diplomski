import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'symptomToString'
})
export class SymptomToStringPipe implements PipeTransform {

  transform (value: string | null): string {
    if (value === null)
      return ""
    switch (value) {
      case 'USLOV_ANK':
        return 'Uslovi za anksioznost'
      case 'ANK':
        return 'Anksioznost'
      case 'GAD':
        return 'Generalni anksiozni poremećaj'
      case 'USLOV_PAN':
        return 'Uslovi za panični napad'
      case 'PAN':
        return 'Panični napad'
      case 'PAN_POR':
        return 'Panični poremećaj'
      case 'USLOV_SOC':
        return 'Uslovi za socijalnu anksioznost'
      case 'SOC':
        return 'Socijalna anksioznost'
      case 'SOC_FOB':
        return 'Socijalna fobija'
      default:
        return value
    }
  }
}
