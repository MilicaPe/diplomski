import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'emotionTypeToString'
})
export class EmotionTypeToStringPipe implements PipeTransform {

  transform (value: string | null): string {
    if (value === null)
      return ""
    switch (value){
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
      default:
        return value
    }
  }

}
