import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { JogadorComponent } from './jogador/jogador.component';

const routes: Routes = [
  { path: '', redirectTo: 'jogador', pathMatch: 'full' },
  { path: 'jogador', component: JogadorComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
