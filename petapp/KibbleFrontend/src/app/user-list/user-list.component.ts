import { Component, OnInit } from '@angular/core';
import { NzMessageService } from 'ng-zorro-antd/message';
import { Observable } from 'rxjs';
import { User } from '../models/User';
import { UserListService } from './user-list.service';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.scss'],
})
export class UserListComponent implements OnInit {
  users$!: Observable<User[]>;
  /**
   *
   */
  constructor(
    private userListService: UserListService,
    private nzMessageService: NzMessageService
  ) {}

  loadAll = () => {
    this.users$ = this.userListService.findAll();
  };
  changeStatus(user: User) {
    this.userListService.update(user).subscribe(() => {
      this.users$ = this.userListService.findAll();
    });
    this.nzMessageService.info('Changed Status');
  }

  deleteUser(user: User) {
    this.userListService.delete(user.id).subscribe(() => {
      this.users$ = this.userListService.findAll();
    });
    this.nzMessageService.warning('User Deleted');
  }

  cancel(): void {
    this.nzMessageService.info('Click cancelled');
  }
  ngOnInit(): void {
    this.users$ = this.userListService.findAll();
  }
}
