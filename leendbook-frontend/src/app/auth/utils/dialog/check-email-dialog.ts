import { Component } from '@angular/core';
import { MatDialogRef } from '@angular/material/dialog';

@Component({
  selector: 'check-email-dialog',
  templateUrl: './check-email-dialog.html',
  styleUrls: ['./check-email-dialog.css']
})
export class CheckEmailDialog {
  constructor(private matDialogRef: MatDialogRef<CheckEmailDialog>) {}
}
