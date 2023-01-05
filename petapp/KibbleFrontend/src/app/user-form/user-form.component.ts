import { Component, Input, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { NzMessageService } from 'ng-zorro-antd/message';
import { UserListService } from '../user-list/user-list.service';

@Component({
  selector: 'app-user-form',
  templateUrl: './user-form.component.html',
  styleUrls: ['./user-form.component.scss'],
})
export class UserFormComponent implements OnInit {
  @Input() refresh!: () => void;

  validateForm!: FormGroup;

  submitForm(value: { firstName: string; completed: boolean }): void {
    for (const key in this.validateForm.controls) {
      if (this.validateForm.controls.hasOwnProperty(key)) {
        this.validateForm.controls[key].markAsDirty();
        this.validateForm.controls[key].updateValueAndValidity();
      }
    }
    value.completed = false;
    this.userListService.create(value).subscribe(() => {
      this.nzMessageService.info('user created');
      this.refresh();
    });
    this.validateForm.reset();
  }
  /**
   *
   */
  constructor(
    private fb: FormBuilder,
    private userListService: UserListService,
    private nzMessageService: NzMessageService
  ) {}
  ngOnInit(): void {
    this.validateForm = this.fb.group({
      firstName: [null, [Validators.required]],
    });
  }
}
