import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DefineRulesComponent } from './define-rules.component';

describe('DefineRulesComponent', () => {
  let component: DefineRulesComponent;
  let fixture: ComponentFixture<DefineRulesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DefineRulesComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DefineRulesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
