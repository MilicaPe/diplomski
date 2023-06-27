import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'detectionTypeToString'
})
export class DetectionTypeToStringPipe implements PipeTransform {


  transform (value: string | null): string {
    if (value === null)
      return ""
    switch (value) {
      case 'SAD':
        return 'Tužno'
      case 'DISGUSTED':
        return 'Gađenje'
      case 'ANGRY':
        return 'Bes'
      case 'FEARFUL':
        return 'Uplašeno'
      case 'BAD':
        return 'Loše'
      case 'SURPRISED':
        return 'Iznenađeno'
      case 'HAPPY':
        return 'Veseo'
      case 'USLOVI_ZA_ANKSIOZNOST':
        return 'Uslovi za anksioznost'
      case 'ANKSIOZNOST':
        return 'Anksioznost'
      case 'GENERALNI_ANKSIOZNI_POREMECAJ':
        return 'Generalni anksiozni poremećaj'
      case 'USLOVI_ZA_PANICNI_NAPAD':
        return 'Uslovi za panični napad'
      case 'PANICNI_NAPAD':
        return 'Panični napad'
      case 'PANICNI_POREMECAJ':
        return 'Panični poremećaj'
      case 'USLOVI_ZA_SOCIJAlNU_ANKSIOZNOST':
        return 'Uslovi za socijalnu anksioznost'
      case 'SOCIJALNA_ANKSIOZNOST':
        return 'Socijalna anksioznost'
      case 'SOCIJALNA_FOBIJA':
        return 'Socijalna fobija'
      default:
        return value
    }
  }
}
