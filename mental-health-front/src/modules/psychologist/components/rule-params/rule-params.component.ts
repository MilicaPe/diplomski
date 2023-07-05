import {Component, EventEmitter, Output} from '@angular/core';
import {RuleParamsDto} from "../../model/rule-params-dto";
import {QuestionService} from "../../../client/services/question-service/question.service";
import {QuestionDto} from "../../../client/model/QuestionDto";

@Component({
  selector: 'app-rule-params',
  templateUrl: './rule-params.component.html',
  styleUrls: ['./rule-params.component.scss']
})
export class RuleParamsComponent {
  @Output() ruleParams = new EventEmitter<RuleParamsDto>()

  public rule: RuleParamsDto = {
    questionId : 0, relation: ">=", value: "4"
  };

  questions: QuestionDto[] = []

  constructor(private questionService:QuestionService) {
  }

  ngOnInit(): void {
    this.questionService.getDepressionQuestionSet().subscribe(res => {
      this.questions = res;
    })
  }

  emitRule() {
    this.ruleParams.emit(this.rule)
  }

}
