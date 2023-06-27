import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DiagnosticSurveyOverviewComponent } from './diagnostic-survey-overview.component';

describe('DiagnosticSurveyOverviewComponent', () => {
  let component: DiagnosticSurveyOverviewComponent;
  let fixture: ComponentFixture<DiagnosticSurveyOverviewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DiagnosticSurveyOverviewComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DiagnosticSurveyOverviewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
