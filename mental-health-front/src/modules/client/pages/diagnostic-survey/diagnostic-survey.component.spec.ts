import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DiagnosticSurveyComponent } from './diagnostic-survey.component';

describe('QuestionsComponent', () => {
  let component: DiagnosticSurveyComponent;
  let fixture: ComponentFixture<DiagnosticSurveyComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DiagnosticSurveyComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DiagnosticSurveyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
