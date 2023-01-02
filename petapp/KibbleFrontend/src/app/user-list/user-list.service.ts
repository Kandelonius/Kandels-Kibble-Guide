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

  update(user: User): Observable<User> {
    const copy = this.convert(user);
    return this.http.put<User>(`${this.resourceUrl}/${copy.id}`, copy);
  }

  find(id: number): Observable<User> {
    return this.http.get<User>(`${this.resourceUrl}/${id}`);
  }

  findAll(): Observable<User[]> {
    return this.http.get<User[]>(this.resourceUrl);
  }

  delete(id: number | undefined): Observable<HttpResponse<any>> {
    return this.http.delete<any>(`${this.resourceUrl}/${id}`)
  }

  private convert(user: User): User {
    const copy: User = Object.assign({}, user);
    return copy;
  }
}
