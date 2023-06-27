import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'dateArrayToString'
})
export class DateArrayToStringPipe implements PipeTransform {

  transform (value: number[]): string {
    let minute : string = value[4].toString();
    if (value[4] < 10) {  minute = '0' + value[4] }
    return value[2] + '. ' + value[1] + '. ' + value[0] + '.  ' + value[3] + ':' + minute
  }

}
