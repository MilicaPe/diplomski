import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'intensityToString'
})
export class IntensityToStringPipe implements PipeTransform {

  transform (value: string | null): string {
    if (value === null)
      return ""
    switch (value) {
      case 'BLAGO':
        return 'Blago'
      case 'UMERENO':
        return 'Umereno'
      case 'IZRAZENO':
        return 'Izraženo'
      case 'TESKO':
        return 'Teško'
      case 'DUBOKO':
        return 'Duboko'
      default:
        return value
    }
  }

}
