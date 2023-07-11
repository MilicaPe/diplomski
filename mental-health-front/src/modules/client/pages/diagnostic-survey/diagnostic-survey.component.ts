import {Component, OnInit} from '@angular/core';
import {QuestionDto} from "../../model/QuestionDto";
import {QuestionService} from "../../services/question-service/question.service";
import {PageEvent} from "@angular/material/paginator";
import {AnswerDto} from "../../model/AnswerDto";
import {MatRadioChange} from "@angular/material/radio";
import {DiagnosticService} from "../../services/diagnostic-service/diagnostic.service";
import {ResultDto} from "../../model/ResultDto";
import {MessageService} from "primeng/api";
import {DetectionTypeService} from "../../../psychologist/services/detection-type-service/detection-type.service";

@Component({
  selector: 'app-diagnostic-survey',
  templateUrl: './diagnostic-survey.component.html',
  styleUrls: ['./diagnostic-survey.component.scss'],
  providers: [MessageService]
})
export class DiagnosticSurveyComponent implements OnInit {
  questions: QuestionDto[] = []
  questionsLen: number = 0
  currentQuestionsToShow: QuestionDto[] = []
  pageSize: number = 10
  pageIndex: number = 0
  answers: AnswerDto[] = []
  resultDto: ResultDto = {diagnostics: []}
  questionHidden = false
  resultHidden = true
  nextLayer: string = "FIRST"
  nextType:string[] = []

  constructor(private questionService: QuestionService,
              private answerService: DiagnosticService,
              private messageService: MessageService,
              private detectionTypeService: DetectionTypeService) {
  }

  ngOnInit(): void {
    this.detectionTypeService.getMentalDetectionTypes().subscribe(res=>{
      for(let detectionTypeDto of res){
        this.nextType.push(detectionTypeDto.type);
      }
      console.log(this.nextType);

      this.questionService.getQuestionSet(this.nextLayer, this.nextType).subscribe(res => {
        this.questions = res.resultList;
        this.questionsLen = res.totalCount;
        this.makeAnswers()
        this.currentQuestionsToShow = this.questions.slice(this.pageIndex * this.pageSize,
          this.pageIndex * this.pageSize + this.pageSize);
        console.log("stigla pitanja")
        console.log(res)
      })
    })
  }

  onPageChange($event: PageEvent) {
    this.currentQuestionsToShow = this.questions.slice($event.pageIndex * $event.pageSize,
      $event.pageIndex * $event.pageSize + $event.pageSize);
  }

  makeAnswers() {
    let list: AnswerDto[] = []
    for (let question of this.questions) {
      let ans: AnswerDto = {questionId: question.id, score: 0, id: 0, userId: 1, time: new Date()};
      list.push(ans)
    }
    this.answers = list
  }

  onRadioButtonSelected(id: number, $event: MatRadioChange) {
    let foundAnswer = this.filterAnswers(id)
    if (foundAnswer !== null) {
      foundAnswer.score = $event.value
    } else {
      let answer: AnswerDto = {id: 0, questionId: id, score: $event.value, time: new Date, userId: 1}
      this.answers.push(answer)
      console.log("novi  ")
      console.log(answer)
    }
    console.log(this.answers)
  }

  filterAnswers(id: number): AnswerDto {
    return this.answers.filter(answer => answer.questionId == id)[0];
  }

  sendAnswers() {
    if (this.isAnswersValid()) {
      console.log("saljem odgovoreee")
      this.answerService.postAnswers(this.answers).subscribe((res) => {
        console.log(res);
        this.resultDto.diagnostics = res.diagnostics//.filter(diagnostic => diagnostic.questionLayer === this.nextLayer);
        this.questionHidden = true;
        this.resultHidden = false;
      })
    } else {
      console.log("nije odgovoreno na sva pitanja")
      this.messageService.add({
        key: 'vimm-questtions',
        severity: 'warn',
        summary: 'Odgovorite na sva pitanja.'
      })
    }
  }

  isAnswersValid() {
    let filtered = this.answers.filter(answer => answer.score == 0);
    return filtered.length == 0;
  }

  nextQuestionnaire($event: ResultDto) {
    this.resultDto = $event
    this.resultHidden = true;
    this.analiseResult()
    this.getNewQuestionSet();

  }

  analiseResult(): void {
    let layer: string = ""
    let type: string[] = []
    for (let d of this.resultDto.diagnostics) {
      if (d.finalResult === false) {
        type.push(d.nextDetection)
        layer = d.nextLayer
      }
    }
    this.nextLayer = layer
    this.nextType = type
  }

  getNewQuestionSet() {
    this.questionService.getQuestionSet(this.nextLayer, this.nextType).subscribe(res => {
      this.questions = res.resultList;
      this.questionsLen = res.totalCount;
      this.pageSize = 10
      this.pageIndex = 0
      this.makeAnswers()
      this.currentQuestionsToShow = this.questions.slice(this.pageIndex * this.pageSize,
        this.pageIndex * this.pageSize + this.pageSize);
      this.questionHidden = false;
      console.log("stigla pitanja")
      console.log(res)
    })
  }
}
