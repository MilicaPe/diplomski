import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RuleParamsComponent } from './rule-params.component';

describe('RuleParamsComponent', () => {
  let component: RuleParamsComponent;
  let fixture: ComponentFixture<RuleParamsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RuleParamsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RuleParamsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
