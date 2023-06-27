import {QuestionAnswerDto} from "./question-answer-dto";

export interface QuestionAnswerByEmotionDto {
  answers: QuestionAnswerDto[]
  emotion: string
}
