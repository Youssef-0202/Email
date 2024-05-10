import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import {ToastModule} from 'primeng/toast';
import {ToolbarModule} from 'primeng/toolbar';
import {TableModule} from 'primeng/table';
import {DropdownModule} from 'primeng/dropdown';
import {InputSwitchModule} from 'primeng/inputswitch';
import {InputTextareaModule} from 'primeng/inputtextarea';

import { ConfirmDialogModule } from 'primeng/confirmdialog';
import { DialogModule } from 'primeng/dialog';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {CalendarModule} from 'primeng/calendar';
import {PanelModule} from 'primeng/panel';
import {InputNumberModule} from 'primeng/inputnumber';
import {BadgeModule} from 'primeng/badge';
import { MultiSelectModule } from 'primeng/multiselect';
import {TranslateModule} from '@ngx-translate/core';
import {FileUploadModule} from 'primeng/fileupload';
import {FullCalendarModule} from '@fullcalendar/angular';
import {CardModule} from "primeng/card";

import { EmailCreateAdminComponent } from './email/create/email-create-admin.component';
import { EmailEditAdminComponent } from './email/edit/email-edit-admin.component';
import { EmailViewAdminComponent } from './email/view/email-view-admin.component';
import { EmailListAdminComponent } from './email/list/email-list-admin.component';
import { EmailDetailCreateAdminComponent } from './email-detail/create/email-detail-create-admin.component';
import { EmailDetailEditAdminComponent } from './email-detail/edit/email-detail-edit-admin.component';
import { EmailDetailViewAdminComponent } from './email-detail/view/email-detail-view-admin.component';
import { EmailDetailListAdminComponent } from './email-detail/list/email-detail-list-admin.component';
import { EmailpieceJoinCreateAdminComponent } from './emailpiece-join/create/emailpiece-join-create-admin.component';
import { EmailpieceJoinEditAdminComponent } from './emailpiece-join/edit/emailpiece-join-edit-admin.component';
import { EmailpieceJoinViewAdminComponent } from './emailpiece-join/view/emailpiece-join-view-admin.component';
import { EmailpieceJoinListAdminComponent } from './emailpiece-join/list/emailpiece-join-list-admin.component';

import { PasswordModule } from 'primeng/password';
import { InputTextModule } from 'primeng/inputtext';
import {ButtonModule} from 'primeng/button';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {RouterModule} from '@angular/router';
import {TabViewModule} from 'primeng/tabview';
import { SplitButtonModule } from 'primeng/splitbutton';
import { MessageModule } from 'primeng/message';
import {MessagesModule} from 'primeng/messages';
import {PaginatorModule} from 'primeng/paginator';



@NgModule({
  declarations: [

    EmailCreateAdminComponent,
    EmailListAdminComponent,
    EmailViewAdminComponent,
    EmailEditAdminComponent,
    EmailDetailCreateAdminComponent,
    EmailDetailListAdminComponent,
    EmailDetailViewAdminComponent,
    EmailDetailEditAdminComponent,
    EmailpieceJoinCreateAdminComponent,
    EmailpieceJoinListAdminComponent,
    EmailpieceJoinViewAdminComponent,
    EmailpieceJoinEditAdminComponent,
  ],
  imports: [
    CommonModule,
    ToastModule,
    ToolbarModule,
    TableModule,
    ConfirmDialogModule,
    DialogModule,
    PasswordModule,
    InputTextModule,
    ButtonModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule,
    SplitButtonModule,
    BrowserAnimationsModule,
    DropdownModule,
    TabViewModule,
    InputSwitchModule,
    InputTextareaModule,
    CalendarModule,
    PanelModule,
    MessageModule,
    MessagesModule,
    InputNumberModule,
    BadgeModule,
    MultiSelectModule,
    PaginatorModule,
    TranslateModule,
    FileUploadModule,
    FullCalendarModule,
    CardModule,

  ],
  exports: [
  EmailCreateAdminComponent,
  EmailListAdminComponent,
  EmailViewAdminComponent,
  EmailEditAdminComponent,
  EmailDetailCreateAdminComponent,
  EmailDetailListAdminComponent,
  EmailDetailViewAdminComponent,
  EmailDetailEditAdminComponent,
  EmailpieceJoinCreateAdminComponent,
  EmailpieceJoinListAdminComponent,
  EmailpieceJoinViewAdminComponent,
  EmailpieceJoinEditAdminComponent,
  ],
})
export class EmailAdminModule { }
