import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../../shared/auth.service';
import { EmitterService } from '../../shared/emitter.service';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.scss']
})
export class AdminComponent implements OnInit {
  showLogin = true;
  showLogout = false;
  constructor(
    private auth: AuthService,
    private router: Router,
    private emitter : EmitterService    
  ) { }

  ngOnInit(): void {
    this.setLoginLogout();
    this.emitter.event.subscribe(() => {
      this.setLoginLogout();
    });
  }

  logout() {
    this.auth.logout().subscribe({
      next: (res) => {
        console.log(res);
        this.setLoginLogout();
        this.router.navigate(['/admin/login']);     
      },
      error: (err) => {
        console.log(err);
      }
    });
  }  
  setLoginLogout() {
    if(this.auth.isLoggedIn()) {
      this.showLogin = false;
      this.showLogout = true;
    }else {
      this.showLogin = true;
      this.showLogout = false;
    }
  }

}
