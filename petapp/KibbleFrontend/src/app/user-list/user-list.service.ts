import { HttpClient, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../models/User';

@Injectable()
export class UserListService {
  private resourceUrl = 'http://localhost:8000/users';

  constructor(private http: HttpClient) {}

  create(user: User): Observable<User> {
    const copy = this.convert(user);
    return this.http.post<User>(this.resourceUrl, copy);
  }
  private convert(user: User): User {
    const copy: User = Object.assign({}, user);
    return copy;
  }
}
