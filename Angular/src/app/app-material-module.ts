import { LayoutModule } from '@angular/cdk/layout';
// import {
//     MatToolbarModule, MatButtonModule, MatSidenavModule, MatIconModule,
//     MatListModule, MatRadioModule, MatSliderModule
// } from '@angular/material/mat';

import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatCardModule } from '@angular/material/card';
import { MatButtonModule } from '@angular/material/button';
import { MatSelectModule } from '@angular/material/select';

// import { MatNativeDateModule, MatBadgeModule, MatSelectModule, MatInputModule, MatMenuModule, 
//     MatExpansionModule, MatChipsModule, MatButtonToggleModule, } from '@angular/material/input';
import { MatRippleModule } from '@angular/material/core';

import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import { MatDialogModule } from '@angular/material/dialog';
import { MatTableModule } from '@angular/material/table';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatGridListModule } from '@angular/material/grid-list';
import { MatSortModule } from '@angular/material/sort';
import { MatCheckboxModule } from '@angular/material/checkbox';
import { MatStepperModule } from '@angular/material/stepper';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatTabsModule } from '@angular/material/tabs';
import { CommonModule } from '@angular/common';
import { MatMenuModule } from '@angular/material/menu';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatDividerModule } from '@angular/material/divider';
import { MatListModule } from '@angular/material/list';
import {MatSnackBarModule} from '@angular/material/snack-bar';

@NgModule({
    imports: [
        CommonModule,
        LayoutModule,
        FormsModule,
        ReactiveFormsModule,
        MatFormFieldModule,
        MatCardModule,
        MatInputModule,
        MatGridListModule,
        MatTableModule,
        MatPaginatorModule,
        MatDialogModule,
        MatSortModule,
        MatCheckboxModule,
        MatStepperModule,
        MatDatepickerModule,
        MatIconModule,
        MatButtonModule,

        // MatRadioModule,
        // MatBadgeModule,
        MatTabsModule,
        MatMenuModule,
        MatSidenavModule,
        MatDividerModule,
        MatListModule,
        MatSelectModule,
        MatRippleModule,
        MatSnackBarModule
    ],
    exports: [
        CommonModule,
        LayoutModule,
        FormsModule,
        ReactiveFormsModule,
        MatFormFieldModule,
        MatCardModule,
        MatInputModule,
        MatGridListModule,
        MatTableModule,
        MatPaginatorModule,
        MatDialogModule,
        MatSortModule,
        MatCheckboxModule,
        MatStepperModule,
        MatDatepickerModule,
        MatIconModule,
        MatButtonModule,
        MatTabsModule,
        MatMenuModule,
        MatSidenavModule,
        MatDividerModule,
        MatListModule,
        MatSelectModule,
        MatRippleModule,
        MatSnackBarModule
    ],
})
export class AppMaterialModule { }
