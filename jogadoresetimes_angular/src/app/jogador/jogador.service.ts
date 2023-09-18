import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Jogador } from './jogador';

@Injectable({
  providedIn: 'root',
})
export class JogadorService {
  constructor(private http: HttpClient) {}

  private url = 'http://localhost:8080/';

  public recuperarJogadores(): Observable<Jogador[]> {
    return this.http.get<any>(`${this.url}jogador`);
  }

  public adicionarJogador(usuario: Jogador): Observable<any> {
    return this.http.post<Jogador>(`${this.url}jogador`, usuario);
  }

  public excluirJogadores(): Observable<any> {
    return this.http.delete<any>(`${this.url}jogador/all`);
  }

  public gerarTimes(): Observable<any> {
    return this.http.get<any>(`${this.url}times`);
  }
}
