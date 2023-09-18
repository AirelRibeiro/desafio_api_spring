import { Component, OnInit } from '@angular/core';
import { Jogador } from './jogador';
import { JogadorService } from './jogador.service';

@Component({
  selector: 'app-jogador',
  templateUrl: './jogador.component.html',
  styleUrls: ['./jogador.component.scss'],
})
export class JogadorComponent implements OnInit {
  constructor(private jogadorService: JogadorService) {}

  jogador: Jogador = new Jogador();
  jogadores: Jogador[] = [];
  times: any = {};

  ngOnInit() {
    this.recuperarJogadores();
  }

  recuperarJogadores(): void {
    this.jogadorService.recuperarJogadores().subscribe(
      (data) => {
        this.jogadores = data;
      },
      (erro) => {
        console.log(erro);
      }
    );
  }

  adicionarJogador(): void {
    this.jogadorService.adicionarJogador(this.jogador).subscribe(
      () => {
        this.jogador = new Jogador();
        this.recuperarJogadores();
      },
      (erro) => {
        console.log(erro);
      }
    );
  }

  gerarTimes(): void {
    this.jogadorService.gerarTimes().subscribe(
      (data) => {
        this.times = data;
      },
      (erro) => {
        console.log(erro);
      }
    );
  }

  limparJogadores(): void {
    this.jogadorService.excluirJogadores().subscribe(
      () => {
        this.jogadores = [];
        this.times = {};
      },
      (erro) => {
        console.log(erro);
      }
    );
  }

  obterChaves(obj: any): string[] {
    return Object.keys(obj);
  }
}
