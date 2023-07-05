export interface DiagnosticDto{
  userId:number,
  intensity:string;
  detectionType:string;
  questionLayer:string;

  nextLayer:string;
  nextDetection:string;
  text:string;
  finalResult:boolean;

}
